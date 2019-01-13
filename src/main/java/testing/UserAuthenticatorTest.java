package testing;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

/**
 * Testing-related terms:
 * <ol>
 * <li>Test Double - Generic term for any substitute object</li>
 * <li>Dummy - A useless test double serving only the purpose of filling the parameter list</li>
 * <li>Fake - A working non-production implementation</li>
 * <li>Stub< - A stub in literal sense/li>
 * <li>Spy - A stub with state recording capability</li>
 * <li>Mock</li>
 * </ol>
 * TDD cycle:
 * <ol>
 * <li>Red - Write a test which fails</li>
 * <li>Green - Write code to make the test pass</li>
 * <li>Refactor - Fix code to perform better and ensure that the test passes</li>
 * </ol>
 */
public class UserAuthenticatorTest {
  private UserAuthenticator userAuthenticator;
  private String user;
  private char[] password;

  @Mock
  AuthenticationService mockAuthenticationService;

  @Before
  public void setUp() {
    initMocks(this);
    userAuthenticator = new DefaultUserAuthenticator(mockAuthenticationService);
  }

  @After
  public void tearDown() {
    verify(mockAuthenticationService).authenticate(user, password);
  }

  @Test
  public void testSuccessfulAuthenticationWithCorrectCredentials() {
    user = "swapna";
    password = "hellokitty".toCharArray();
    when(mockAuthenticationService.authenticate(anyString(), any(new char[0].getClass()))).thenReturn(true);
    assertThat(userAuthenticator.authenticate(user, password), is(true));
  }

  @Test
  public void testSuccessfulAuthenticationWithIncorrectCredentials() {
    user = "swapna";
    password = "incorrectPassword".toCharArray();
    when(mockAuthenticationService.authenticate(user, password)).thenReturn(false);
    assertThat(userAuthenticator.authenticate(user, password), is(false));
  }
}
