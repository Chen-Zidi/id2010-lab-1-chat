// ChatServerInterface.java
// 2018-08-22/fki Refactored for lab version 7
// 14-oct-2004/FK New package.
// 25-mar-2004/FK New package.
// 18-mar-2004/FK First version

package chat.server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

import net.jini.core.event.RemoteEventListener;

/**
 * This interface is implemented by the ChatServer, and is used by ChatClient
 * to place requests. It must therefore be known to both implementations.
 */
public interface ChatServerInterface
  extends
    java.rmi.Remote
{
  /**
   * Used by ChatClient instances to inject a text message to be
   * distributed to registered ChatClientNotificationInterfaces.
   * @param msg The message.
   */
  public void say (String msg)
    throws java.rmi.RemoteException;

  /**
   * Returns the server's user-friendly name.
   * @return The server's user-friendly name.
   */
  public String getName () throws java.rmi.RemoteException;

  /**
   * added
   * Returns the name of active clients in the server.
   * @return The name of active clients in the server.
   */
  public HashMap<String, String> getActiveClients() throws java.rmi.RemoteException;


  /**
   * added
   * update the client's name.
   */
  public void updateClientName(RemoteEventListener rel, String name, String oldName) throws java.rmi.RemoteException;


  /**
   * edited
   * Used by ChatClient instances to register themselves as receivers of
   * remote notifications.
   * @param rel An object that implements net.jini.core.event.RemoteEvent
   *            interface.
   */
  public void register (RemoteEventListener rel, String name)
    throws java.rmi.RemoteException;

  /**
   *
   * Used by ChatClient instances to unregister themselves as receivers of
   * remote notifications.
   * @param rel An object that implements net.jini.core.event.RemoteEvent
   *            interface. This should be the same object as was originally
   *            used to register.
   */
  public void unregister (RemoteEventListener rel)
    throws java.rmi.RemoteException;

  /**
   * added
   * add to the byte length of the messages that the client has sent
   * @param rel An object that implements net.jini.core.event.RemoteEvent
   *            interface. This should be the same object as was originally
   *            used to register.
   * @throws java.rmi.RemoteException
   */
  public void addTextLen(RemoteEventListener rel, int length)
    throws java.rmi.RemoteException;
}
