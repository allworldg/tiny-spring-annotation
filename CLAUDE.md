# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

This is "my-tiny-spring" - a minimal implementation of an IoC (Inversion of Control) container, inspired by the Spring Framework's core dependency injection mechanism. It demonstrates the fundamental patterns of com.example.bean definition, registration, and retrieval.

## Build and Run

This project uses plain Java with IntelliJ IDEA. No build tools (Maven/Gradle) are configured.

- **Compile**: `javac src/**/*.java -d out/`
- **Run**: `java -cp out/ com.example.Main`
- **Or use**: IntelliJ IDEA's built-in build/run (Press Shift+F10)

## Architecture

The codebase follows the classic IoC container pattern with three layers:

### Core Abstractions (`com.example.factory/`)

- **`BeanFactory`** - Interface defining the contract for com.example.bean registration (`registerBeanDefinition`) and retrieval (`getBean`)
- **`AbstractBeanFactory`** - Template method pattern implementation:
  - Maintains a registry of `BeanDefinition` objects
  - Implements `registerBeanDefinition` which creates the com.example.bean instance via abstract `createBean()` method
  - Implements `getBean` to retrieve registered beans
- **`AutoWireBeanFactory`** - Concrete implementation that creates com.example.bean instances using reflection (`Class.newInstance()`)

### Bean Model (`com.example.bean/`)

- **`BeanDefinition`** - Holds com.example.bean metadata:
  - `beanClass` - The Class object for instantiation
  - `beanClassName` - String representation of the class name
  - `com.example.bean` - The actual com.example.bean instance

## Design Patterns Used

- **Template Method**: `AbstractBeanFactory` defines the registration flow, subclasses implement `createBean()`
- **Factory**: `BeanFactory` and its implementations encapsulate object creation
- **Registry**: Internal Map stores com.example.bean definitions by name

## Working with Beans

When adding new beans:
1. Create the com.example.bean class in `com.example.bean/` package
2. Create a `BeanDefinition` and set its class via `setBeanClass()`
3. Register with `AutoWireBeanFactory.registerBeanDefinition(name, definition)`
4. Retrieve via `com.example.factory.getBean(name)`
