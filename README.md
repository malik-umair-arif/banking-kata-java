# Banking Kata - Java

[![CI](https://github.com/valentinacupac/banking-kata-java/actions/workflows/ci.yaml/badge.svg)](https://github.com/valentinacupac/banking-kata-java/actions/workflows/ci.yaml)

## Purpose

This demo was created for the purposes of meetup series on TDD & Clean Architecture. See the [YouTube Meetups](https://journal.optivem.com/p/foundations-of-tdd-and-clean-architecture). Please note that this project is purely for demo purposes only.

## Overview

This project illustrates TDD & Clean Architecture implementation in Java, showing the Use Case Driven Development
Approach.

We implement a Banking system with the following use cases:

- Open account
- Withdraw funds
- Deposit funds
- View account

We also have authentication with Keycloak - a realm with client_id and with client_credentials flow enabled.

## Prerequisites

- OpenJDK 17
- Docker

## Running Unit Tests

Run unit tests for `core` and `adapters-fake`:

```
./gradlew core:test
./gradlew adapters-fake:test
```

## Running Integration Tests

Apply the environment variables (Windows):

```shell
. .\env\env.ps1
```

Apply the environment variables (for Linux/Mac):

```shell
source ./env/env.sh
```

For Mac only, you need to build a custom Keycloak image to enable Keycloak to work on Mac M1.
This is due to a reported Mac-specific issue https://github.com/docker/for-mac/issues/5310.
For any other OS, please skip this step, because this issue is Mac-specific:

```shell
./src/main/resources/keycloak/build-keycloak-image-m1.zsh 16.0.0
```

Run docker:

```shell
docker-compose up -d
```

Run the integration tests:

```
./gradlew adapters:test
```

<!--- TODO: VC: System tests -->


### Code Coverage & Mutation Testing

Run JaCoCo code coverage:

```
./gradlew jacocoTestReport
```

Run PIT mutation testing (TODO: VC: Fix this):

```
./gradlew pitest
```

## Reports

See the `build\reports` directory for the generated reports for test results, code coverage and mutation testing.

Reports:

- build\reports\tests
- build\reports\jacoco
- build\reports\pitest

## Optional Notes

Environment variables are located inside the `env` folder. You can optionally choose to edit them.

You can choose to run the tests via IntelliJ UI. 

In the case of integration tests (for `adapters`) you'd have to specify environment variables before you run the tests.
To do that, you can copy the text from the file `env/env.intellij.ui` into the `Environment variables` section into `Tests in 'banking-kata.adapters'` configuration.

To run Docker with the environment file:

```shell
docker-compose --env-file=env/.env.local up -d
```

## Issues

If you experience Integration Tests failing, please see the following known issue https://github.com/valentinacupac/banking-kata-java/issues/64.

If you experience any other issues, please create a ticket https://github.com/valentinacupac/banking-kata-java/issues/new

## Contributors

Our contributors are:
- [Valentina Cupać](https://www.linkedin.com/in/valentinacupac/) ([valentinacupac](https://github.com/valentinacupac))
- [Amin Talukder](https://www.linkedin.com/in/amin-talukder/) ([eamtalu](https://github.com/eamtalu))
- [Adrián Lizaga](https://www.linkedin.com/in/adrian-lizaga/) ([adrianliz](https://github.com/adrianliz))
- [Franco Lombardo](https://www.linkedin.com/in/francolombardo/) ([f-lombardo](https://github.com/f-lombardo))
- [Donald Siziba](https://www.linkedin.com/in/donald-siziba-35603322/) ([donaldsiziba](https://github.com/donaldsiziba))

If you'd like to contribute, see instructions here https://github.com/valentinacupac/banking-kata-java/blob/main/CONTRIBUTING.md
