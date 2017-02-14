package com.tereha.java.training.rx;

import rx.Observable;
import rx.Observer;
import rx.functions.Func1;

/**
 * Created by tereha on 14.02.17.
 */
class CreatorsOperators {

    void testOperatorFrom() {
        Observable<String> observable = Observable.from(new String[]{"One", "Two", "Three"});

        Observer<String> observer = new Observer<String>() {
            public void onCompleted() {
                System.out.println("onCompleted()");
            }

            public void onError(Throwable e) {
                System.out.println("onError() " + e.getMessage());
            }

            public void onNext(String s) {
                System.out.println("onNext() " + s);
            }
        };

        observable.subscribe(observer);
    }

    void testOperatorRange() {
        Observable<Integer> observable = Observable.range(10, 4);

        Observer<Integer> observer = new Observer<Integer>() {
            public void onCompleted() {
                System.out.println("onCompleted()");
            }

            public void onError(Throwable e) {
                System.out.println("onError() " + e.getMessage());
            }

            public void onNext(Integer integer) {
                System.out.println("onNext() " + integer);
            }
        };

        observable.subscribe(observer);
    }

    void testOperatorMap(){
        Func1<String, Integer> stringToInteger = new Func1<String, Integer>() {
            public Integer call(String s) {
                return Integer.parseInt(s);
            }
        };

        Observable<Integer> observable = Observable.from(new String[]{"1", "2", "3", "4", "5", "a"})
                .map(stringToInteger);

        Observer<Integer> observer = new Observer<Integer>() {
            public void onCompleted() {
                System.out.println("onCompleted()");
            }

            public void onError(Throwable e) {
                System.out.println("onError(), exception: " + e.getClass().getSimpleName() + ": " + e.getMessage());
            }

            public void onNext(Integer integer) {
                System.out.println("onNext() " + integer);
            }
        };

        observable.subscribe(observer);
    }
}
