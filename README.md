# airqueue
```
              .------,
              =\      \
 .---.         =\      \
 | C~ \         =\      \
 |     `----------'------'----------,
.'     LI.-.LI LI LI LI LI LI LI.-.LI`-.
\ _/.____|_|______.------,______|_|_____)
                 /      /
               =/      /
              =/      /
             =/      /
      jgs    /_____,'
```

## Running Instructions

1. `git clone` this project

2. Open in your IDE (we use IntelliJ), if necessary import microservices **booking**, **notification**, **orchestrator** and **payment-mono**
as Maven projects by right-clicking the `pom.xml` of the respective microservice.

3. `cd` into root folder and run `docker-compose up`.

4. Start the microservices in your IDE. We use the following sequence:
    1. booking
    2. orchestrator
    3. payment-mono
    4. notification
    
5. Open [localhost:8091](http://localhost:8091), submit a start, a destination (no specific input required)
and your e-mail-address.
   
To look at the Camunda Cockpit, open [localhost:8092](http://localhost:8092).

## Troubleshooting

- Class not found error: Run `maven clean`, and then `maven compile`or higher. Run the service again.
- Database errors: Delete `.db` files at the root directory
- Unresolved dependencies: Use the *Reload Maven Dependencies* function of IntelliJ, reimport the Maven project or delete
the `.iml` file of the microservice and then reimport the Maven project.