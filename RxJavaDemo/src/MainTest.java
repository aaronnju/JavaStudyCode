import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by shuming.wang on 2017-1-20.
 */
public class MainTest {
    public static void main(String[] arg){
        MainTest t = new MainTest();
        t.doSomeWork();
    }

    /*
     * simple example to emit two value one by one
     */
    private void doSomeWork() {
        getObservable()
                // Run on a background thread
                .subscribeOn(Schedulers.io())
                // Be notified on the main thread
//                .observeOn(Schedulers.)
                .subscribe(getObserver());
    }

    private Observable<String> getObservable() {
        return Observable.just("Cricket", "Football");
    }

    private Observer<String> getObserver() {
        return new Observer<String>() {

            @Override
            public void onSubscribe(Disposable d) {
                System.out.println(" onSubscribe : " + d.isDisposed());
            }

            @Override
            public void onNext(String value) {
                System.out.println(" onNext : value : " + value);
            }

            @Override
            public void onError(Throwable e) {
                System.out.println(" onError : " + e.getMessage());

            }

            @Override
            public void onComplete() {
                System.out.println(" onComplete");
            }
        };
    }



}
