# Apricart-E-commerce-Solution
An e-commerce platform.

### Overview

**Apricart** is a comprehensive e-commerce platform designed to manage products, shopping carts, orders, coupons, and warehouses efficiently. Built using Spring Boot, this project offers a robust backend solution for modern e-commerce applications, ensuring smooth operations and a seamless shopping experience.

### Features

- **Product Management**: 
  - Create, update, delete, and retrieve product information.
  - Manage product details including name, description, price, brand, availability, and warehouse location.

- **Cart Management**: 
  - Add, update, and remove products in the shopping cart.
  - Retrieve cart items and calculate the total price.

- **Order Management**: 
  - Place new orders and update order status.
  - Retrieve orders by user or order ID and calculate total order price.
  - Cancel orders and manage order fulfillment.

- **Coupon Management**: 
  - Validate and apply coupon codes.
  - Manage coupon details including discount amount, minimum order amount, applicable city, and warehouse.

- **Warehouse Management**: 
  - Create, update, delete, and retrieve warehouse information.
  - Manage warehouse capacity and product storage.

- **Checkout Process**: 
  - Process checkout requests and handle payment.
  - Calculate total payable amount including discounts and taxes.
  - Generate order IDs and send confirmation notifications.

### Technologies Used

- **Spring Boot**: Core framework for building the application.
- **Spring Data JPA**: Simplifies database interactions using JPA.
- **Spring Web**: Provides RESTful web services capabilities.
- **Hibernate**: ORM tool for database operations.
- **MySQL/PostgreSQL**: Relational database management system.
- **Logback/Log4j2**: Logging frameworks for error and exception tracking.
- **JUnit**: Testing framework for unit and integration tests.

### Getting Started

1. **Clone the repository**:
   ```bash
   git clone https://github.com/wasid-khan/apricart.git
   cd apricart
   ```

2. **Set up the database**:
   - Configure your database settings in `application.properties`.

3. **Run the application**:
   ```bash
   ./mvnw spring-boot:run
   ```

4. **API Documentation**:
   - Access the API documentation at `http://localhost:8080/swagger-ui.html` (if Swagger is configured) or refer to the included Postman collection for API details.

### Contributing

Contributions are welcome! Please fork the repository and create a pull request with your changes. Ensure your code follows the project’s coding standards and includes appropriate tests.

### License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

### Contact
For any inquiries or support, please contact [your-email@example.com](wakhan.msis23seecs@seecs.edu.pk).
