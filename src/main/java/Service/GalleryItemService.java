/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entity.Comment;
import Entity.GalleryItem;
import Repository.GalleryItemRepository;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 * This provides services for the GalleryItem
 *
 * @author Samual Martelli
 */
@Service
@GraphQLApi
public class GalleryItemService {

    private final GalleryItemRepository galleryItemRepository;

    public enum CommentSource {
        REDDIT, NONE
    }
    public GalleryItemService(GalleryItemRepository serviceRepository) {
        galleryItemRepository = serviceRepository;
    }

    /**
     * READ ALL GalleryItems
     */
    @GraphQLQuery(name = "galleryItems")
    public List<GalleryItem> getGalleryItems() {
        return galleryItemRepository.findAll();
    }

    /**
     * READ GalleryItem by Id
     */
    @GraphQLQuery(name = "galleryItem") // READ BY ID
    public Optional<GalleryItem> getGalleryItemById(@GraphQLArgument(name = "id") Long id) {
        return galleryItemRepository.findById(id);
    }

    /**
     * Saves the gallery item
     * @param item
     * @return 
     */
     @GraphQLMutation(name = "saveGalleryItem")
    public GalleryItem saveGalleryItem(@GraphQLArgument(name = "galleryItem") GalleryItem item) {
        return galleryItemRepository.save(item);
    }
    
    /**
     * Remove the gallery item
     * @param item
     * @return 
     */
     @GraphQLMutation(name = "deleteGalleryItem")
    public void deleteGalleryItem(@GraphQLArgument(name = "id") Long id) {
        galleryItemRepository.deleteById(id);
    }
    
    public ArrayList<Comment> fetchComments(CommentSource source, @GraphQLArgument(name = "id") Long id) {
        GalleryItem item = galleryItemRepository.getById(id);
        ArrayList<Comment> commentBuilder = new ArrayList();
        switch(source) {
            case REDDIT:
               //api call to get comments from reddit given the link
                //add comment if absent
               break;
            case NONE: //DEFAULT CASE
                 commentBuilder.addAll(item.getComments());
               break;
        }
        return commentBuilder;
    }
}
