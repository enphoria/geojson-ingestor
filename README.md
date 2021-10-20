# MS Geojson Ingestor

Microservices for extracting information from a geojson

## Starting 🚀

_These instructions will allow you to get a copy of the project running on your local machine for development and testing purposes._

see **Deploy** to know how to deploy the project


### Information 📋

_Microservices for extracting information from a geojson_
_Host in production http://xxxxx_


### Install 🔧

Initially you should download the repository

```
git clone enphoria/geojson-ingestor
```

Perform the project build

```
mvn clean install
```

Start the project

```
java -jar ms-geojson-ingestor-0.0.1-SNAPSHOT.jar
```

## Running the tests ⚙️

_To run the tests you must use the following command_

```
mvn test
```
_This will generate a report, it is attached to the test / html folder, inside it is the index.html where you can see the generated coverage report_

## Deploy 📦

_pending_

```
--
```

## Documentation 📦

_Inside the microservice you can find the documentation in Swagger in the folder documentation / yaml called:_

```
ms-geojson-ingestor.yaml
```

## Built with 🛠️

_The technologies used are mentioned below:_

* [Spring Boot](https://spring.io/projects/spring-boot) - framework backend
* [Maven](https://maven.apache.org/) - Build automation tool
* [Jacoco](https://www.eclemma.org/jacoco/) - Testing report
* [Mockito](https://site.mockito.org/) - Framework testing


## Autor ✒️

* **Camilo Cárdenas** - *Developer* - [github](https://github.com/kmilo95)

## Licencia 📄

This project is under the License  [LICENSE.md](LICENSE.md) for more details