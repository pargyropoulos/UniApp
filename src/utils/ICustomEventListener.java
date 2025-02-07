
package utils;

/**
 *
 * @author Panagiotis Argyropoulos - pargyropoulos@gmail.com or
 * std154845@ac.eap.gr
 * @param <T>
 */
@FunctionalInterface
public interface ICustomEventListener <T> {
    public void onCustomEvent(CustomEvent<T> e);
}
