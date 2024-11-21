//package com.library.springbootlibrary;
//
//import com.library.springbootlibrary.controller.AdminController;
//import com.library.springbootlibrary.requestmodels.AddBookRequest;
//import com.library.springbootlibrary.service.AdminService;
//import com.library.springbootlibrary.utils.ExtractJwt;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//
//import static org.mockito.Mockito.*;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//@WebMvcTest(AdminController.class)
//public class AdminControllerTest {
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private AdminService adminService;
//
//    @BeforeEach
//    void setUp() {
//        Mockito.mockStatic(ExtractJwt.class); // Mock static utility method
//    }
//
//    @Test
//    void testPostBookWithValidAdminToken() throws Exception {
//        // Mock the token extraction
//        when(ExtractJwt.payloadJwtExtraction(anyString(), anyString()))
//                .thenReturn("admin");
//
//        AddBookRequest addBookRequest = new AddBookRequest();
//        addBookRequest.setTitle("Sample Book");
//        addBookRequest.setAuthor("Sample Author");
//
//        mockMvc.perform(post("/api/admin/secure/add/book")
//                        .header("Authorization", "Bearer sampleToken")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content("""
//                                {
//                                  "title": "Sample Book",
//                                  "author": "Sample Author"
//                                }
//                                """))
//                .andExpect(status().isOk());
//
//        verify(adminService, times(1)).postBook(any(AddBookRequest.class));
//    }
//
//    @Test
//    void testPostBookWithInvalidAdminToken() throws Exception {
//        when(ExtractJwt.payloadJwtExtraction(anyString(), anyString()))
//                .thenReturn("user");
//
//        mockMvc.perform(post("/api/admin/secure/add/book")
//                        .header("Authorization", "Bearer invalidToken")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content("""
//                                {
//                                  "title": "Sample Book",
//                                  "author": "Sample Author"
//                                }
//                                """))
//                .andExpect(status().isInternalServerError())
//                .andExpect(content().string("Administration page only"));
//
//        verify(adminService, never()).postBook(any(AddBookRequest.class));
//    }
//
//
//
//
//
//    @Test
//    void testDecreaseBookQuantityWithInvalidAdminToken() throws Exception {
//        when(ExtractJwt.payloadJwtExtraction(anyString(), anyString()))
//                .thenReturn(null);
//
//        mockMvc.perform(put("/api/admin/secure/decrease/book/quantity")
//                        .header("Authorization", "Bearer invalidToken")
//                        .param("bookId", "1"))
//                .andExpect(status().isInternalServerError())
//                .andExpect(content().string("Administration page only"));
//
//        verify(adminService, never()).decreaseBookQuantity(anyLong());
//    }
//
//    @Test
//    void testDeleteBookWithValidAdminToken() throws Exception {
//        when(ExtractJwt.payloadJwtExtraction(anyString(), anyString()))
//                .thenReturn("admin");
//
//        mockMvc.perform(delete("/api/admin/secure/delete/book")
//                        .header("Authorization", "Bearer sampleToken")
//                        .param("bookId", "1"))
//                .andExpect(status().isOk());
//
//        verify(adminService, times(1)).deleteBook(1L);
//    }
//
//    @Test
//    void testDeleteBookWithInvalidToken() throws Exception {
//        when(ExtractJwt.payloadJwtExtraction(anyString(), anyString()))
//                .thenReturn("user");
//
//        mockMvc.perform(delete("/api/admin/secure/delete/book")
//                        .header("Authorization", "Bearer invalidToken")
//                        .param("bookId", "1"))
//                .andExpect(status().isInternalServerError())
//                .andExpect(content().string("Administration page only"));
//
//        verify(adminService, never()).deleteBook(anyLong());
//    }
//}
