package com.ssafy.model.dto.member;
public class MemberDto {
    private String membername;
    private String memberid;
    private String memberpwd;
    private String memberemail;
    private String membertell;


    public void setMembername(String membername) { 
        this.membername = membername;
    }

    public String getMembername() { 
        return membername;
    }

    public void setMemberid(String memberid) { 
        this.memberid = memberid;
    }

    public String getMemberid() { 
        return memberid;
    }

    public void setMemberpwd(String memberpwd) { 
        this.memberpwd = memberpwd;
    }

    public String getMemberpwd() { 
        return memberpwd;
    }

    public void setMemberemail(String memberemail) { 
        this.memberemail = memberemail;
    }

    public String getMemberemail() { 
        return memberemail;
    }

    public void setMembertell(String membertell) { 
        this.membertell = membertell;
    }

    public String getMembertell() { 
        return membertell;
    }
}