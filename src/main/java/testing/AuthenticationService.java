package testing;

/**
 * AuthenticationService to authenticate users
 */
public interface AuthenticationService {
  boolean authenticate(String userName, char[] password);
}
