package testing;

public class FileAuthenticationService implements AuthenticationService {
  @Override
  public boolean authenticate(String userName, char[] password) {
    return true;
  }
}
