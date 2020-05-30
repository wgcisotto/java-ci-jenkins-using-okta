# Simple Application with Okta OIDC Authentication
Clone the project and run the application with Maven:
```shell
git clone https://github.com/<your-username>/simple-app.git
cd simple-api
OKTA_OAUTH2_CLIENT_ID={youtOktaClientId} \
OKTA_OAUTH2_CLIENT_SECRET={yourOktaClientSecret} \
OKTA_OAUTH2_ISSUER={yourOktaDomain}/oauth2/default \
./mvnw spring-boot:run
```