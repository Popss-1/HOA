package com.bigbrain.v1.controllers;

import com.bigbrain.v1.DAOandRepositories.AnnouncementRepository;
import com.bigbrain.v1.models.Announcements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AnnouncementController {

    private AnnouncementRepository announcementRepository;

    @Autowired
    public AnnouncementController(AnnouncementRepository announcementRepository) {
        this.announcementRepository = announcementRepository;
    }

    @GetMapping("/admin/createannouncement")
    public String createAnnouncement(){

        return "createannouncement";
    }

    @PostMapping("/admin/createannouncement")
    public String submitAnnouncement(@ModelAttribute("newAnnouncement") Announcements newAnnouncement){
        announcementRepository.save(newAnnouncement);
        return "redirect:/admin/allannouncements";
    }

    @GetMapping("/admin/allannouncements")
    public String showAllAnnouncements(){
        List<Announcements> allAnnouncements = announcementRepository.findAll();
        return "allannouncements";
    }

    @GetMapping("/admin/updateannouncment{announcementIDPK}")
    public String updateAnnouncement(@PathVariable int announcementIDPK){
        Announcements announcementUpdatable = announcementRepository.findByPk(announcementIDPK);
        return "announcementUpdateForm";
    }

    @PostMapping("/admin/updateannouncment")
    public String submitUpdateAnnouncement(@ModelAttribute("updateAnnouncement") Announcements updateAnnouncement){
        announcementRepository.update(updateAnnouncement, updateAnnouncement.getAnnouncementIDPK());
        return "redirect:/admin/allannouncements";
    }

    @GetMapping("/admin/deleteannouncenment{announcementIDPK}")
    public String deleteAnnouncement(@PathVariable int announcementIDPK){
        announcementRepository.deleteByID(announcementIDPK);
        return "redirect:/admin/allannouncements";
    }
}
