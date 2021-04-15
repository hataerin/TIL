package com.ssafy.model.dto.clinic;
public class ClinicDto {
    private String no;
    private String date;
    private String samplecollection;
    private String sido;
    private String gugunName;
    private String hospital;
    private String address;
    private String weekdaytime;
    private String saturdaytime;
    private String holidaytime;
    private String repnumber;

    public void setNo(String no) { 
        this.no = no;
    }

    public String getNo() { 
        return no;
    }

    public void setDate(String date) { 
        this.date = date;
    }

    public String getDate() { 
        return date;
    }

    public void setSamplecollection(String samplecollection) { 
        this.samplecollection = samplecollection;
    }

    public String getSamplecollection() { 
        return samplecollection;
    }

    public void setSido(String sido) { 
        this.sido = sido;
    }

    public String getSido() { 
        return sido;
    }

    public void setGugunName(String gugunName) { 
        this.gugunName = gugunName;
    }

    public String getGugunName() { 
        return gugunName;
    }

    public void setHospital(String hospital) { 
        this.hospital = hospital;
    }

    public String getHospital() { 
        return hospital;
    }

    public void setAddress(String address) { 
        this.address = address;
    }

    public String getAddress() { 
        return address;
    }

    public void setWeekdaytime(String weekdaytime) { 
        this.weekdaytime = weekdaytime;
    }

    public String getWeekdaytime() { 
        return weekdaytime;
    }

    public void setSaturdaytime(String saturdaytime) { 
        this.saturdaytime = saturdaytime;
    }

    public String getSaturdaytime() { 
        return saturdaytime;
    }

    public void setHolidaytime(String holidaytime) { 
        this.holidaytime = holidaytime;
    }

    public String getHolidaytime() { 
        return holidaytime;
    }

    public void setRepnumber(String repnumber) { 
        this.repnumber = repnumber;
    }

    public String getRepnumber() { 
        return repnumber;
    }
}