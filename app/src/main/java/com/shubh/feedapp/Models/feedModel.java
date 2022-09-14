package com.shubh.feedapp.Models;

public class feedModel {

    String Description, Image, Name, Sender, Key, NameComment, ImageComment, Message;
    int Likes, nComments;

    public feedModel(String description, String image, String name, String sender, int likes, int ncomments) {
        Description = description;
        Image = image;
        Name = name;
        Sender = sender;
        Likes = likes;
        nComments = ncomments;
    }


    public feedModel(String nameComment, String imageComment, String message) {
        NameComment = nameComment;
        ImageComment = imageComment;
        Message = message;
    }

    public String getNameComment() {
        return NameComment;
    }

    public void setNameComment(String nameComment) {
        NameComment = nameComment;
    }

    public String getImageComment() {
        return ImageComment;
    }

    public void setImageComment(String imageComment) {
        ImageComment = imageComment;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public feedModel(String key) {
        Key = key;
    }

    //empty constructor for firebase
    public feedModel() { }

    public int getnComments() {
        return nComments;
    }

    public void setnComments(int nComments) {
        this.nComments = nComments;
    }

    public String getKey() {
        return Key;
    }

    public void setKey(String key) {
        Key = key;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSender() {
        return Sender;
    }

    public void setSender(String sender) {
        Sender = sender;
    }

    public int getLikes() {
        return Likes;
    }

    public void setLikes(int likes) {
        Likes = likes;
    }
}
