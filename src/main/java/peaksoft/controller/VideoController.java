package peaksoft.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import peaksoft.entity.Company;
import peaksoft.entity.Video;
import peaksoft.service.VideoService;

import java.util.List;

@Controller
@RequestMapping("/api/videos")
public class VideoController {
    private final VideoService videoService;

    public VideoController(VideoService videoService) {
        this.videoService = videoService;
    }
    @ModelAttribute("videoList")
    public List<Video> allVideos(){
        return videoService.getAllVideos();
    }
    @GetMapping
    public String getAll(){
        return "videoPage";
    }
}
