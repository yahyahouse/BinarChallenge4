package com.yahya.challenge4.controller;

import com.yahya.challenge4.service.InvoiceService;
import com.yahya.challenge4.service.SchedulesService;
import com.yahya.challenge4.service.SeatsService;
import com.yahya.challenge4.service.UsersService;
import io.swagger.v3.oas.annotations.Operation;
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
    @Autowired
    private SchedulesService schedulesService;
    @Autowired
    private UsersService usersService;

    @Autowired
    SeatsService seatsService;

    @Operation(summary = "menampilkan tiket dengan format pdf")
    @GetMapping("/tiket-bioskop")
    public void generateInvoice1(HttpServletResponse response) throws JRException, IOException {
        invoiceService.generateInvoice(response);
    }

}
