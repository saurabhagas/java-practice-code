package testing;

public interface UserAuthenticator {
  boolean authenticate(String userName, char[] password);
}
