package com.vocaldoc.service;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.File;
import java.util.Scanner;
import com.vocaldoc.model.Document;
import com.vocaldoc.repository.DocumentRepository;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import java.io.FileInputStream;
import java.util.List;

@Service
public class DocumentService {
    @Autowired
    DocumentRepository documentRepository;

    public Document save(Document doc) {
        return documentRepository.save(doc);
    }


    public String extractText(String filepath)

            throws Exception {
        String lowerpath = filepath.toLowerCase();

        if(!(lowerpath.endsWith(".txt") || !lowerpath.endsWith(".pdf") || !lowerpath.endsWith(".docx"))){
            return "Only TXT, PDF, DOCX files allowed";
        }

        if(lowerpath.endsWith(".txt")) {
            File file = new File(filepath);

            Scanner scanner = new Scanner(file);

            StringBuilder text = new StringBuilder();

            while (scanner.hasNextLine()) {

                text.append(scanner.nextLine());
                text.append("\n");
            }

            scanner.close();
            return text.toString();
        }

        else if(lowerpath.endsWith(".pdf")){

            PDDocument document = PDDocument.load(new File(filepath));
            PDFTextStripper pdfstripper = new PDFTextStripper();

            String text = pdfstripper.getText(document);

            document.close();

            return text;
        }

         else if (lowerpath.endsWith(".docx")) {
            FileInputStream fis = new FileInputStream(filepath);

            XWPFDocument document = new XWPFDocument(fis);

            List<XWPFParagraph> paragraphs = document.getParagraphs();

            StringBuilder text = new StringBuilder();

            for(XWPFParagraph para : paragraphs){
                text.append(para.getText());
                text.append("\n");
            }

            document.close();

            return text.toString();
        }
        return "Error extracting file";
    }
}