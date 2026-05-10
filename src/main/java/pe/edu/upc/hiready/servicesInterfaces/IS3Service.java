package pe.edu.upc.hiready.servicesInterfaces;

import org.springframework.web.multipart.MultipartFile;

public interface IS3Service {
    String uploadFile(MultipartFile file, String folder);
    void deleteFile(String fileUrl);
}
