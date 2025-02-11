package nl.solevision.svscan.util;

public class Authorization {

    public String getAuthorizationUrl() {
        String clientId = "e9aa4b61-f68a-45c3-b238-b790b847230a";
        String redirectUri = "http://localhost";
        String scopes = "crm.objects.contacts.write crm.objects.contacts.read";

        return "https://app.hubspot.com/oauth/authorize?" +
                "client_id=" + clientId +
                "&redirect_uri=" + redirectUri +
                "&scope=" + scopes;
    }
}
