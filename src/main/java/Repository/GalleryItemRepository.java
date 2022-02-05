/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository;

import Entity.GalleryItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * This is the repository for holding gallery items
 * @author Samual Martelli
 */
@Repository
public interface GalleryItemRepository extends JpaRepository<GalleryItem, Long> {
}
