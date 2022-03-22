package com.example.inq_proj.card;

public class CardModelse {

    private String fr_card_text;
    private String se_card_text;
    private int card_image;

    public CardModelse(String fr_card_text, String se_card_text, int card_image) {
        this.fr_card_text = fr_card_text;
        this.se_card_text = se_card_text;
        this.card_image = card_image;
    }

    public String getFr_card_text() {
        return fr_card_text;
    }

    public void setFr_card_text(String fr_card_text) {
        this.fr_card_text = fr_card_text;
    }

    public String getSe_card_text() {
        return se_card_text;
    }

    public void setSe_card_text(String se_card_text) {
        this.se_card_text = se_card_text;
    }

    public int getCard_image() {
        return card_image;
    }

    public void setCard_image(int card_image) {
        this.card_image = card_image;
    }
}
