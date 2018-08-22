package com.santech.hongbao.module.main.di.component;

import com.jess.arms.di.component.AppComponent;
import com.jess.arms.di.scope.ActivityScope;
import com.santech.hongbao.module.main.di.module.MainModule;
import com.santech.hongbao.module.main.ui.activity.MainActivity;

import dagger.Component;

@ActivityScope
@Component(modules = MainModule.class, dependencies = AppComponent.class)
public interface MainComponent {

    void inject(MainActivity activity);

}