package com.yahya.challenge4.service;

import com.yahya.challenge4.model.Schedules;
import com.yahya.challenge4.model.Seats;
import com.yahya.challenge4.model.Users;
import com.yahya.challenge4.repository.FilmRepository;
import com.yahya.challenge4.repository.SchedulesRepository;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class InvoiceServiceImp implements InvoiceService {
    @Autowired
    private FilmService filmService;

    @Autowired
    private SchedulesService schedulesService;

    @Autowired
    private FilmRepository filmRepository;

    @Autowired
    private SchedulesRepository schedulesRepository;

    @Autowired
    private UsersService usersService;

    @Autowired
    SeatsService seatsService;

    @Override
    public void generateInvoice(HttpServletResponse response) throws IOException, JRException {
        JasperReport sourceFileName = JasperCompileManager
                .compileReport(ResourceUtils.getFile(ResourceUtils.CLASSPATH_URL_PREFIX
                        + "tiketBioskop.jrxml").getAbsolutePath());

        List<Map<String, String>> dataList = new ArrayList<>();
        Map<String, String> data = new HashMap<>();
        Users user = usersService.getUsersByUsername("yahya");
        data.put("username", user.getUsername());
        Seats seat = seatsService.getNoKursi(1, "A");
        data.put("noKursi", String.valueOf(seat.getId().getNoKursi()));
        data.put("studioName", String.valueOf(seat.getId().getStudioName()));
        Schedules schedule = schedulesService.getSchedulesById(1L);
        data.put("filmName", String.valueOf(schedule.getFilmCode().getFilmName()));
        data.put("tglTayang", schedule.getTglTayang());
        data.put("jamMulai", schedule.getJamMulai());
        data.put("jamSelesai", schedule.getJamSelesai());
        dataList.add(data);

        // creating datasource from bean list
        JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(dataList);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("createdBy", "Yahya");
        JasperPrint jasperPrint = JasperFillManager.fillReport(sourceFileName, parameters, beanColDataSource);
        response.setContentType("application/pdf");
        response.addHeader("Content-Disposition", "inline; filename=tiketBioskop.pdf;");

        JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());
    }
}
