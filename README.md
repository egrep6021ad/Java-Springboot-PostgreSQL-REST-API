# Java API

- This is an API that accepts a users data and calculates a quote in dollars based on said data. The original data, and the quote are stored in a postgreSQL database before be auomatically emailed to the user.

## Development

- endpoint: 8080/api/v1/clients.

## Production

- uncomment send message in "new client controller" then reconfig:
  - spring.mail.host= smtp.gmail. com
  - spring.mail.port=587
  - spring.mail.username= < email/ username>
  - spring.mail.password= < password>
