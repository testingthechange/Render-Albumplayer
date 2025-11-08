package com.maven.album;

import java.time.LocalDateTime;

public class IncomingRecord {
    private Long projectId;
    private String producerName;
    private String projectStartDate;
    private LocalDateTime dateReceived;

    private String album8;
    private String shuffle8;
    private String album9;
    private String shuffle9;
    private String meta;
    private String[] songPages = new String[9];

    public Long getProjectId() { return projectId; }
    public void setProjectId(Long projectId) { this.projectId = projectId; }

    public String getProducerName() { return producerName; }
    public void setProducerName(String producerName) { this.producerName = producerName; }

    public String getProjectStartDate() { return projectStartDate; }
    public void setProjectStartDate(String projectStartDate) { this.projectStartDate = projectStartDate; }

    public LocalDateTime getDateReceived() { return dateReceived; }
    public void setDateReceived(LocalDateTime dateReceived) { this.dateReceived = dateReceived; }

    public String getAlbum8() { return album8; }
    public void setAlbum8(String album8) { this.album8 = album8; }

    public String getShuffle8() { return shuffle8; }
    public void setShuffle8(String shuffle8) { this.shuffle8 = shuffle8; }

    public String getAlbum9() { return album9; }
    public void setAlbum9(String album9) { this.album9 = album9; }

    public String getShuffle9() { return shuffle9; }
    public void setShuffle9(String shuffle9) { this.shuffle9 = shuffle9; }

    public String getMeta() { return meta; }
    public void setMeta(String meta) { this.meta = meta; }

    public String[] getSongPages() { return songPages; }
    public void setSongPages(String[] songPages) { this.songPages = songPages; }
}
