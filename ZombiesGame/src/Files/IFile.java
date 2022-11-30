package Files;

import java.util.ArrayList;

public interface IFile <T, R> {

    public R load(T classToLoad);

}
