package com.springbootlearning.learnspringboot3.ch2;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class VideoService {

  private List<Video> videos = List.of( // immutable list
    new Video("Need HELP with your SPRING BOOT 3 App?"), //
    new Video("Don't do THIS to your own CODE!"), //
    new Video("SECRETS to fix BROKEN CODE!"));

  public List<Video> getVideos() {
    return videos;
  }

  public Video create(Video newVideo) {
	  // complicated with an extra copy so that existing copies are not mutated
    List<Video> extend = new ArrayList<>(videos);
    extend.add(newVideo);
    this.videos = List.copyOf(extend); 
    return newVideo;
  }
}
