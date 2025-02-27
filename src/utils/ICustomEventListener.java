
package utils;

/**
 * Interface for custom listener
 * @param <T>
 */
@FunctionalInterface
public interface ICustomEventListener <T> {
    public void onCustomEvent(CustomEvent<T> e);
}
