package com.example.alopet;

public class acc {
    private String mail;
    private String pw;

    public acc(String mail, String pw) {
        this.mail = mail;
        this.pw = pw;
    }

    public String getMail() {
        return mail;
    }
    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }
}
