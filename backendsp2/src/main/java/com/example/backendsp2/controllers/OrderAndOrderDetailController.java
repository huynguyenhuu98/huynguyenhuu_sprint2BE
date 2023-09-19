package com.example.backendsp2.controllers;

import com.example.backendsp2.config.JwtTokenUtil;
import com.example.backendsp2.model.*;
import com.example.backendsp2.repository.IOrdersRepository;
import com.example.backendsp2.service.*;
import com.example.backendsp2.service.impl.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

@RestController
@RequestMapping("/api/order/orderDetail")
@CrossOrigin("*")
public class OrderAndOrderDetailController {
    @Autowired
    private IOrdersService iOrdersService;
    @Autowired
    private IProductRacingService iProductRacingService;
    @Autowired
    private ICartsService iCartsService;
    @Autowired
    private IUsersService iUsersService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private ICustomersService iCustomerService;
    @Autowired
    private IOrdersDetailService iOrdersDetailService;
    @Autowired
    private EmailService emailService;
    private String body;

    @PostMapping("/{totalPrice}")
    public void payment(@PathVariable int totalPrice) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        Users users = iUsersService.findByUserName(username);
        Customers customers = iCustomerService.getUsersId(users.getId());

        Orders orders = new Orders();
        orders.setCustomers(customers);
        orders.setCodeOrders("111");
        orders.setTotalPrice(totalPrice);
        orders.setCreateDate(LocalDateTime.now());
        iOrdersService.save(orders);

        List<Carts> cartList = iCartsService.findAll();
        for (int i = 0; i < cartList.size(); i++) {
            ProductRacing productRacing = iProductRacingService.findByIdProduct(cartList.get(i).getProductRacing().getId()).get();
            productRacing.setQuantity(cartList.get(i).getProductRacing().getQuantity() - cartList.get(i).getQuantity());

            iProductRacingService.saveProduct(productRacing);
            OrdersDetail ordersDetail = new OrdersDetail();
            ordersDetail.setQuantity(cartList.get(i).getQuantity());
            ordersDetail.setProductRacing(cartList.get(i).getProductRacing());
//            ordersDetail.setCustomer(customer);
            ordersDetail.setOrders(orders);
            ordersDetail.setPrice(cartList.get(i).getProductRacing().getPrice());
            iOrdersDetailService.save(ordersDetail);
            iCartsService.delete(cartList.get(i));
        }
    }


//    @Transactional
//    @PostMapping()
//    @PreAuthorize("hasRole('ROLE_CUSTOMER')")
//    public ResponseEntity<?> saveOrderAndOrderDetail(HttpServletRequest httpServletRequest ) {
//        String header = httpServletRequest.getHeader("Authorization");
//        String token = header.substring(7);
//        String username = jwtTokenUtil.getUsernameFromToken(token);
//        Customers customers = iCustomerService.findUsersId(username);
//
//        List<Carts> shoppingCartList = iCartsService. findAllByShopping(customers.getId());
//        Long totalPrice = 0L;
//        for (int i = 0; i < shoppingCartList.size(); i++) {
//            totalPrice += shoppingCartList.get(i).getProductRacing().getPrice() * shoppingCartList.get(i).getQuantity();
//        }
//        List<Orders> ordersList = new ArrayList<>();
//        long code;
//        Random random = new Random();
//        long min = 10000; // Số nhỏ nhất có 5 chữ số
//        long max = 99999; // Số lớn nhất có 5 chữ số
//        boolean flag;
//        String orderCode;
//        do {
//            flag = true;
//            code = random.nextLong() % (max - min + 1) + min;
//            orderCode = "OD" + code;
//            for (int i = 0; i < ordersList.size(); i++) {
//                if (Objects.equals(ordersList.get(i).getCodeOrders(), orderCode)) {
//                    flag = false;
//                }
//            }
//        } while (!flag);
//        Orders orders = new Orders(totalPrice, orderCode, customers);
//        iOrdersRepository.save(orders);
//        Integer amount = 0;
//        for (int i = 0; i < shoppingCartList.size(); i++) {
//            OrdersDetail ordersDetail = new OrdersDetail(
//                    shoppingCartList.get(i).getQuantity(),
//                    shoppingCartList.get(i).getProductRacing().getPrice(),
//                    shoppingCartList.get(i).getProductRacing(),
//                    orders);
//            iOrdersDetailService.save(ordersDetail);
//            amount = (ordersDetail.getProductRacing().getQuantity() - ordersDetail.getQuantity());
//            System.out.println(amount);
//            ordersDetail.getProductRacing().setQuantity(amount);
//            iCartsService.deleteById(shoppingCartList.get(i).getCustomers());
//            iCartsService.delete(shoppingCartList.get(i));
//        }
//        List<OrdersDetail> ordersDetailList = iOrdersDetailService.findAllOrdersDetail(orders.getId());
//
//        String to = customers.getEmail();
//        String subject = "Bạn có đơn hàng từ DaNaBike Shop";
//        body = "<h4>Chào " + customers.getNameCustomer() + ",</p>\n" +
//                "\n" +
//                "<p>Chúng tôi gửi mail này để xác nhận rằng bạn vừa thanh toán một đơn hàng thành công từ Fruit Shop </p>\n" +
//                "\n" +
//                "<p>Dưới đây là chi tiết hóa đơn của bạn:</p>\n";
//        String table = "<table border={1}  style=\"border: 1px solid #DDDDDD;\">";
//        table += "<tr>" +
//                "<th>Sản phẩm</th>" + "<th>Hình Ảnh</th>" + "<th>Số lượng</th>" + "<th>Giá tiền</th>" +
//                "</tr>";
//        for (int i = 0; i < ordersDetailList.size(); i++) {
//            table += "<tr>" +
//                    "<td>" + ordersDetailList.get(i).getProductRacing().getNameRacing() + "</td>" +
//                    "<td>"+"<img style=\"width: 20%;\" "+"src="+ordersDetailList.get(i).getProductRacing().getImages()+">"+"</td>"+
//                    "<td>" + ordersDetailList.get(i).getQuantity() + "</td>" +
//                    "<td>" + ordersDetailList.get(i).getProductRacing().getPrice() + "</td>" +
//                    "</tr>";
//        }
//        table += "</table>";
//        body += table;
//        body += "\n<p>Chúng tôi xin cảm ơn quý khách đã tin tường và sử dụng dịch vụ của chúng tôi.</p>\n" +
//                "</br>" +
//                "\n" +
//                "</br>" +
//                "</br>" +
//                "\n" +
//                "</br>" +
//                "</br>" +
//                "\n" +
//                "<p>---------------------------------------</p>" + "\n" +
//                "<p>Name: DANABIKE</p>\n" +
//                "<p>Mobile: (+84) 835-443-443</p>\n" +
//                "<p>Email: danabike@gmail.com</p>\n" +
//                "<p>Address: 393 Nguyễn Phước Nguyên, Thanh Khê, Đà Nẵng</p>";
//        System.out.println(body);
//        emailService.sendMail(to, subject, body);
//        return new ResponseEntity<>(orders,HttpStatus.OK);


    @GetMapping("/history")
    @PreAuthorize("hasAnyRole('ROLE_CUSTOMER','ROLE_ADMIN')")
    public ResponseEntity<List<Orders>> getAll(HttpServletRequest httpServletRequest) {
        String header = httpServletRequest.getHeader("Authorization");
        String token = header.substring(7);
        String username = jwtTokenUtil.getUsernameFromToken(token);
        Customers customers = iCustomerService.findUsersId(username);

        if (customers != null) {
            List<Orders> ordersList = iOrdersService.findAll(customers.getId());
            return new ResponseEntity<>(ordersList, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/history/detail")
    @PreAuthorize("hasAnyRole('ROLE_CUSTOMER','ROLE_ADMIN')")
    public ResponseEntity<List<OrdersDetail>> historyDetail(@RequestParam("id") Long id) {
        List<OrdersDetail> orders = iOrdersDetailService.findAllOrders(id);

        return new ResponseEntity<>(orders, HttpStatus.OK);
    }
}



