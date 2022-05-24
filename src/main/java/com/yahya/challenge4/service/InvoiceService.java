package com.yahya.challenge4.service;

import net.sf.jasperreports.engine.JRException;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface InvoiceService {
    void generateInvoice(HttpServletResponse response) throws IOException, JRException;
}
