/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.Normalizer;
/**
 *
 * @author doanm
 */
public class test {
    public static String generateSlug(String title) {
        // Normalize string (remove accents and special characters)
        String normalized = Normalizer.normalize(title, Normalizer.Form.NFD)
                                      .replaceAll("[^\\p{ASCII}]", "") // non-ASCII character to ""
                                      .toLowerCase();
        
        // Replace spaces with hyphens and remove any non-alphanumeric characters
        String slug = normalized.replaceAll("[\\s+]", "-")
                                .replaceAll("[^a-z0-9-]", "");
        
        return slug;
    }
    public static void main(String[] args) {
        try{
            
        String title = "Thủ tướng: \"Không có doanh nhân giỏi, đất nước không thể thịnh vượng\"";
        String id = "1234";
        String slug = generateSlug(title) + id;
        System.out.println(slug);
        } catch(Exception e){
            
        }
    }
}
