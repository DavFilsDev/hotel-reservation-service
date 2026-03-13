# Hotel Booking Service 🏨

A RESTful API for managing hotel room reservations with intelligent availability validation and room number constraints. Built with Spring Boot, this service provides a robust backend for hotel booking systems.

## ✨ Features

- 📝 **Create Bookings** - Register new reservations with customer details
- 📋 **List Bookings** - View all existing reservations
- ✅ **Availability Validation** - Prevent double-booking of rooms
- 🔢 **Room Number Constraints** - Rooms numbered strictly from 1 to 9
- 🚫 **Conflict Detection** - Clear error messages for unavailable rooms
- 💾 **In-Memory Storage** - Fast, lightweight data management
- 🎯 **Input Validation** - Comprehensive request validation
- 🔒 **Proper HTTP Status Codes** - RESTful response conventions

## 🛠️ Technology Stack

- **Java 21** - Modern Java features and improvements
- **Spring Boot 3.2.3** - Robust framework for microservices
- **Spring Web MVC** - REST API development
- **Spring Validation** - Request validation
- **Maven** - Dependency management and build tool
- **JUnit** - Testing framework

## 📋 API Endpoints

### GET /api/bookings
Retrieves all existing bookings in the system.

**Response:** `200 OK`
```json
[
  {
    "customerName": "Alice Martin",
    "phoneNumber": "0123456789",
    "email": "alice@email.com",
    "roomNumber": 3,
    "roomDescription": "Chambre standard",
    "bookingDate": "05/09/2025"
  }
]
```

### POST /api/bookings
Creates a new booking after validating room availability.

**Request Body:**
```json
{
  "customerName": "John Doe",
  "phoneNumber": "+33123456789",
  "email": "john.doe@email.com",
  "roomNumber": 5,
  "roomDescription": "Suite with ocean view",
  "bookingDate": "25/12/2025"
}
```

**Success Response:** `200 OK` (returns all bookings including the new one)
```json
[
  {
    "customerName": "John Doe",
    "phoneNumber": "+33123456789",
    "email": "john.doe@email.com",
    "roomNumber": 5,
    "roomDescription": "Suite with ocean view",
    "bookingDate": "25/12/2025"
  }
]
```

## 🚦 HTTP Status Codes

| Status Code | Description | When it occurs |
|------------|-------------|----------------|
| **200 OK** | Success | Booking created successfully or list retrieved |
| **400 Bad Request** | Validation error | Invalid input (room number not 1-9, invalid email, missing fields) |
| **409 Conflict** | Room unavailable | Room already booked for the specified date |
| **500 Internal Server Error** | Server error | Unexpected server-side error |

## 📊 Validation Rules

| Field | Rules | Example |
|-------|-------|---------|
| customerName | Required, not blank | "Marie Dubois" |
| phoneNumber | Required, not blank | "+33612345678" |
| email | Required, valid email format | "marie@email.com" |
| roomNumber | Required, between 1 and 9 | 5 |
| roomDescription | Optional | "Chambre avec vue" |
| bookingDate | Required, format dd/MM/yyyy | "25/12/2025" |

## 🚀 Getting Started

### Prerequisites
- Java 21 or higher
- Maven 3.6+
- Git

### Installation

1. **Clone the repository**
   ```bash
   git clone https://github.com/DavFilsDev/hotel-booking-service.git
   cd hotel-booking-service
   ```

2. **Build the project**
   ```bash
   mvn clean install
   ```

3. **Run the application**
   ```bash
   mvn spring-boot:run
   ```

4. **Access the API**
   ```
   Base URL: http://localhost:8080
   API Endpoint: http://localhost:8080/api/bookings
   ```

## 📝 Usage Examples

### Using cURL

**Get all bookings:**
```bash
curl -X GET http://localhost:8080/api/bookings
```

**Create a new booking:**
```bash
curl -X POST http://localhost:8080/api/bookings \
  -H "Content-Type: application/json" \
  -d '{
    "customerName": "Jean Dupont",
    "phoneNumber": "0123456789",
    "email": "jean@email.com",
    "roomNumber": 7,
    "roomDescription": "Chambre familiale",
    "bookingDate": "15/08/2025"
  }'
```

### Using Postman

1. Create a new POST request to `http://localhost:8080/api/bookings`
2. Set Headers: `Content-Type: application/json`
3. Add JSON body as shown above
4. Send request and check response

## 🎯 Error Responses

### Validation Error (400 Bad Request)
```json
{
  "status": 400,
  "message": "Validation failed: {roomNumber=Room number must be between 1 and 9, email=Invalid email format}",
  "timestamp": 1709123456789
}
```

### Room Unavailable (409 Conflict)
```json
{
  "status": 409,
  "message": "Room 5 is not available for date 2025-12-25",
  "timestamp": 1709123456789
}
```

## 🏗️ Project Structure

```
src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── example/
│   │           └── hotelbooking/
│   │               ├── controller/
│   │               │   └── BookingController.java
│   │               ├── service/
│   │               │   └── BookingService.java
│   │               ├── repository/
│   │               │   └── BookingRepository.java
│   │               ├── model/
│   │               │   └── Booking.java
│   │               ├── dto/
│   │               │   ├── BookingRequest.java
│   │               │   ├── BookingResponse.java
│   │               │   └── ErrorResponse.java
│   │               ├── exception/
│   │               │   └── GlobalExceptionHandler.java
│   │               └── HotelBookingApplication.java
│   └── resources/
│       └── application.properties
└── test/
    └── java/
```

## 🧪 Testing the API

You can test the API using various tools:

1. **Browser**: Visit `http://localhost:8080/api/bookings` for GET requests
2. **cURL**: Command-line HTTP client
3. **Postman**: GUI tool for API testing
4. **Insomnia**: Alternative API client

## 🔄 Sample Test Flow

1. **Check initial bookings** (GET)
2. **Create valid booking** (POST with room 5 for 25/12/2025)
3. **Try to create duplicate** (POST same room and date → 409 Conflict)
4. **Try invalid room number** (POST room 10 → 400 Bad Request)
5. **Verify final bookings** (GET shows all successful bookings)

## 🤝 Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'feat: add some amazing feature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📄 License

This project is licensed under the MIT License - see the LICENSE file for details.

## ✉️ Contact

Fanampinirina Miharisoa David Fils RATIANDRAIBE - miharisoadavidfils@gmail.com

Project Link: [https://github.com/DavFilsDev/hotel-booking-service](https://github.com/yourusername/hotel-booking-service)

## 🙏 Acknowledgments

- Spring Boot Documentation
- REST API Best Practices
- Hotel booking system requirements

---

**Made with ❤️ for seamless hotel reservations**