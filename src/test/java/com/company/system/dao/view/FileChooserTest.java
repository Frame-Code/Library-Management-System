package com.company.system.dao.view;

import com.company.system.view.FileChooser;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author artist-code (Daniel Mora Cantillo)
 */
public class FileChooserTest {
    FileChooser fileChooser;
    
    @BeforeEach
    void setUp() {
        this.fileChooser = new FileChooser();
    }
    
    @Test
    void upload() {
        System.out.println(fileChooser.filePath());
    }
            

}
