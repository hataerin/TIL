package com.ssafy.model.dto.hospital;
public class HospitalDto {
    private String no;
    private String date;
    private String sido;
    private String gugunName;
    private String hospital;
    private String address;
    private String applytype;
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

    public void setApplytype(String applytype) { 
        this.applytype = applytype;
    }

    public String getApplytype() { 
        return applytype;
    }

    public void setRepnumber(String repnumber) { 
        this.repnumber = repnumber;
    }

    public String getRepnumber() { 
        return repnumber;
    }
}