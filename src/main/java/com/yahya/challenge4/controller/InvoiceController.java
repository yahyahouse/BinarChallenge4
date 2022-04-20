package com.yahya.challenge4.controller;

import com.yahya.challenge4.service.InvoiceService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/invoice/api")
public class InvoiceController {
    @Autowired
    private InvoiceService invoiceService;

    @GetMapping("/tiket-bioskop")
    public void getTiket(HttpServletResponse response) throws JRException, IOException {
        response.setContentType("application/pdf");
        response.addHeader("Content-Disposition", "inline; filename=tiketBioskop.pdf;");
        invoiceService.generateInvoice(response);
    }
}
