/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import io.leangen.graphql.annotations.GraphQLQuery;
import java.util.ArrayList;

import javax.persistence.Id;
import javax.persistence.GeneratedValue;

/**
 * A GalleryItem is a piece of artistic content where we can view the art, its
 * name, the artist name, and the comments.
 *
 * @author Samual Martelli
 */
public class GalleryItem {

    @Id
    @GeneratedValue
    @GraphQLQuery(name = "id", description = "A gallery item's id")
    private Long id;

    @GraphQLQuery(name = "name", description = "A gallery item's name")
    private String name;

    @GraphQLQuery(name = "artistName", description = "The artist of a gallery item's name")
    private String artistName;

    @GraphQLQuery(name = "comments", description = "A gallery item's comments")
    private ArrayList<Comment> comments;

    @GraphQLQuery(name = "imageLink", description = "The URL of the gallery item's image")
    private String imageLink;

    @GraphQLQuery(name = "itemLink", description = "The URL of the gallery item")
    private String itemLink;

    @GraphQLQuery(name = "totalCommentCount", description = "Number of comments on a gallery item")
    private Integer totalCommentCount;

    public Long getId() {
        return id;
    }

    public void setId(Long newId) {
        id = newId;
    }

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        name = newName;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String newArtistName) {
        artistName = newArtistName;
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public void setComments(ArrayList<Comment> allComments) {
        comments = allComments;
    }

    public Integer getTotalCommentCount() {
        return comments.size();
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String link) {
        imageLink = link;
    }

    public String getItemLink() {
        return itemLink;
    }

    public void setItemLink(String link) {
        itemLink = link;
    }

    @Override
    public String toString() {
        return "GalleryItem{"
                + "id=" + id
                + ", name='" + name
                + ", artist name='" + artistName
                + ", image link='" + imageLink + '\''
                + ", item link='" + itemLink + '\''
                + ", comments{'" + totalCommentCount + "}'\'"
                + '}';
    }
}
