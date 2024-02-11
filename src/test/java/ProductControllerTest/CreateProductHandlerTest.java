//package ProductControllerTest;
//
//import com.example.demo.DemoApplication;
//import com.example.demo.Product.Model.Product;
//import com.example.demo.Product.Repository.ProductRepository;
//import com.example.demo.Product.commandHandler.CreateProductCommandHandler;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//@SpringBootTest(classes = DemoApplication.class)
//public class CreateProductHandlerTest {
//
//    @InjectMocks
//    private CreateProductCommandHandler createProductCommandHandler;
//
//    @Mock
//    private ProductRepository productRepository;
//
//    @Test
//    public void TestCreateProduct() {
//        Product product = new Product();
//        product.setId(1);
//        product.setPrice(2.12);
//        product.setName("Bets");
//        product.setDescription("mieu ta Bets");
//        product.setQuantity(12123);
//        ResponseEntity res = createProductCommandHandler.excute(product);
////        assertEquals(HttpStatus.OK, res.getStatusCode());
//    }
//
//}
