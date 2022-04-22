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


//    @Operation(summary = "menampilkan tiket dengan format pdf")
//    @GetMapping("/tiket-bioskop")
//    public void generateInvoice(HttpServletResponse response) throws IOException, JRException {
//        JasperReport sourceFileName = JasperCompileManager
//                .compileReport(ResourceUtils.getFile(ResourceUtils.CLASSPATH_URL_PREFIX
//                        + "tiketBioskop.jrxml").getAbsolutePath());
//
//        // creating our list of beans
////        List<Users> dataList = new ArrayList<>();
//        List<Map<String, String>> dataList = new ArrayList<>();
//        Map<String, String> data = new HashMap<>();
//        Users user = usersService.getUsersByUsername("yahya");
//        data.put("username", user.getUsername());
//        Seats seat = seatsService.getNoKursi(1,"A");
//        data.put("noKursi", String.valueOf(seat.getId().getNoKursi()));
//        data.put("studioName", String.valueOf(seat.getId().getStudioName()));
//        Schedules schedule = schedulesService.getSchedulesById(1L);
//        data.put("filmName", String.valueOf(schedule.getFilmCode().getFilmName()));
//        data.put("tglTayang",schedule.getTglTayang());
//        data.put("jamMulai",schedule.getJamMulai());
//        data.put("jamSelesai",schedule.getJamSelesai());
//        dataList.add(data);
//
//        // creating datasource from bean list
//        JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(dataList);
//        Map<String, Object> parameters = new HashMap();
//        parameters.put("createdBy", "Yahya");
//        JasperPrint jasperPrint = JasperFillManager.fillReport(sourceFileName, parameters, beanColDataSource);
//        response.setContentType("application/pdf");
//        response.addHeader("Content-Disposition", "inline; filename=tiketBioskop.pdf;");
//
//        JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());
//    }
}
