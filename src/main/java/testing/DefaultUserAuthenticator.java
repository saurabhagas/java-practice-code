package testing;

public class DefaultUserAuthenticator implements UserAuthenticator {
  private final AuthenticationService authenticationService;

  public DefaultUserAuthenticator(AuthenticationService authenticationService) {
    this.authenticationService = authenticationService;
  }

  @Override
  public boolean authenticate(String userName, char[] password) {
    return authenticationService.authenticate(userName, password);
  }
}
