
## Getting started

### 1. Download development tools

#### Mainly used Android Studio version

```
Android Studio Dolphin | 2021.3.1 Patch 1
Build #AI-213.7172.25.2113.9123335, built on September 30, 2022
Runtime version: 11.0.13+0-b1751.21-8125866 aarch64
VM: OpenJDK 64-Bit Server VM by JetBrains s.r.o.
macOS 12.6
GC: G1 Young Generation, G1 Old Generation
Memory: 4096M
Cores: 8
Registry:
    external.system.auto.import.disabled=true
    ide.text.editor.with.preview.show.floating.toolbar=false
    ide.instant.shutdown=false
```

[Download latest Android Studio](https://developer.android.com/studio)

[Android Studio Download Archives](https://developer.android.com/studio/archive?hl=ja)

### 2. Build with Android Studio

Switch AndroidStudio's `Active Build Variant`. We develop using the following categories:


### 3. Settings pre-commit

To run ktlint on a local commit, execute the following command
```
# Do the following directly under the project
# git config --local core.hooksPath scripts/git/hooks

# Do the following directly under the project
$ chmod ug+x scripts/git/hooks/pre-commit
```

Check that the following settings are reflected in `$PROJECT_ROOT/.git/config`
```
[core]
        repositoryformatversion = 0
        filemode = true
        bare = false
        logallrefupdates = true
        ignorecase = true
        precomposeunicode = true
        hooksPath = scripts/git/hooks <--This adds.
```

#### *Only for those that need

## Coding convention

Please write code according to Lint in Android Studio.


## Branch strategy

We are operating with the best of GitHub Flow and git-flow.


## Development tools


### CI/CD

Used to distribute develop and stating to Firebase App Distribution, and production to Google Play Console.


### Error visualization and monitoring tools


You can check the stack trace at the time of error occurrence, request data, etc. on the dashboard.


## Reference

