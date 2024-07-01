# API Usage Guide of CSV-Parser
This guide provides instructions on how to run the Spring Boot application locally and details the important endpoints for making API calls.
# Prerequisites
Before running the application, ensure you have the following installed on your machine:

-> Java 21

-> Maven

# Running the Application Locally
Clone the Repository:
```
bash
    git clone <repository-url>
    cd <repository-directory>
```

Build the Application:
```
bash
mvn clean install
```

Run the Application:
```
bash
mvn spring-boot:run
```
By default, the application runs on port 8080.

# Important Endpoints
-> CSV Upload Endpoint

URL: /api/csv/upload

Method: POST

Description: Uploads a CSV file to the server. 

Request Parameters:

file (MultipartFile): The CSV file to upload.

Example using curl:
```
bash
curl -F "file=@path/to/your/file.csv" http://localhost:8080/api/csv/upload
```

-> CSV Search Endpoint

URL: /api/csv/search

Method: GET

Description: Searches for records in the uploaded CSV files based on a query string.

Request Parameters:

query (String): The search term.

Example using curl:
```
bash
curl "http://localhost:8080/api/csv/search?query=searchterm"
```

-> Metrics Endpoint

URL: /actuator/prometheus

Method: GET

Description: Exposes metrics in a format compatible with Prometheus.

Example using curl:
```
bash
curl http://localhost:8080/actuator/prometheus
```

# Monitoring with Prometheus
To monitor the application using Prometheus:

-> Install Prometheus:
Download and extract Prometheus from the official website.

-> Configure Prometheus:
Create a prometheus.yml configuration file with the following content:
```

yaml
    global:
        scrape_interval: 15s
scrape_configs:
    - job_name: 'spring-boot'
    metrics_path: '/actuator/prometheus'
    static_configs:
        - targets: ['localhost:8080']
```

-> Run Prometheus: 

Navigate to the Prometheus directory and run it:
```
bash
prometheus --config.file=prometheus.yml
```

-> Access Prometheus:

Open your browser and go to:
```
http://localhost:9090
```

-> Query Metrics:
Use the Prometheus UI to query metrics like csv_uploads_total and csv_searches_total.

-> Conclusion
By following this guide, you can run the Spring Boot application locally, upload and search CSV files, and monitor the application's metrics using Prometheus. For any further questions or issues, please refer to the project documentation or contact the development team.