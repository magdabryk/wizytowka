package pl.camp.it.wizytowka.model;

public class Mail {
    private String name;
    private String surname;
    private String mailContent;

    public Mail(String name, String surname, String mailContent) {
        this.name = name;
        this.surname = surname;
        this.mailContent = mailContent;
    }

    public Mail() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMailContent() {
        return mailContent;
    }

    public void setMailContent(String mailContent) {
        this.mailContent = mailContent;
    }
}
