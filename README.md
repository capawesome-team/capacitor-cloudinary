<p align="center"><br><img src="https://avatars.githubusercontent.com/u/105555861" width="128" height="128" /></p>
<h3 align="center">Cloudinary</h3>
<p align="center"><strong><code>@capawesome/capacitor-cloudinary</code></strong></p>
<p align="center">
  Capacitor plugin for integrating with Cloudinary.
</p>

<p align="center">
  <img src="https://img.shields.io/maintenance/yes/2022?style=flat-square" />
  <a href="https://github.com/capawesome-team/capacitor-cloudinary/actions?query=workflow%3A%22CI%22"><img src="https://img.shields.io/github/workflow/status/capawesome-team/capacitor-cloudinary/CI/main?style=flat-square" /></a>
  <a href="https://www.npmjs.com/package/@capawesome/capacitor-cloudinary"><img src="https://img.shields.io/npm/l/@capawesome/capacitor-cloudinary?style=flat-square" /></a>
<br>
  <a href="https://www.npmjs.com/package/@capawesome/capacitor-cloudinary"><img src="https://img.shields.io/npm/dw/@capawesome/capacitor-cloudinary?style=flat-square" /></a>
  <a href="https://www.npmjs.com/package/@capawesome/capacitor-cloudinary"><img src="https://img.shields.io/npm/v/@capawesome/capacitor-cloudinary?style=flat-square" /></a>
  <a href="https://github.com/capawesome-team"><img src="https://img.shields.io/badge/part%20of-capawesome-%234f46e5?style=flat-square" /></a>
</p>

## Maintainers

| Maintainer | GitHub                                    | Social                                        |
| ---------- | ----------------------------------------- | --------------------------------------------- |
| Robin Genz | [robingenz](https://github.com/robingenz) | [@robin_genz](https://twitter.com/robin_genz) |

## Sponsors

This is an MIT-licensed open source project.
It can grow thanks to the support by these awesome people.
If you'd like to join them, please read more [here](https://github.com/sponsors/capawesome-team).

<!-- sponsors --><!-- sponsors -->

<a href="https://github.com/cycraft"><img src="https://github.com/cycraft.png" alt="cycraft" style="max-width: 100%;" width="50px"></a>

## Installation

```bash
npm install @capawesome/capacitor-cloudinary
npx cap sync
```

### Android

#### Variables

This plugin will use the following project variables (defined in your app’s `variables.gradle` file):

- `$cloudinaryAndroidVersion` version of `com.cloudinary:cloudinary-android` (default: `2.3.0`)

## Configuration

No configuration required for this plugin.

## Demo

A working example can be found here: [robingenz/capacitor-plugin-demo](https://github.com/robingenz/capacitor-plugin-demo)

## Usage

```typescript
import { Cloudinary, ResourceType } from '@capawesome/capacitor-cloudinary';

const initialize = async () => {
  await Cloudinary.initialize({ cloudName: 'my_cloud_name' });
};

const uploadResource = async () => {
  await Cloudinary.uploadResource({
    resourceType: ResourceType.image,
    uploadPreset: 'my_preset',
    publicId: 'my_public_id',
  });
};
```

## API

<docgen-index>

* [`initialize(...)`](#initialize)
* [`uploadResource(...)`](#uploadresource)
* [Interfaces](#interfaces)
* [Enums](#enums)

</docgen-index>

<docgen-api>
<!--Update the source file JSDoc comments and rerun docgen to update the docs below-->

### initialize(...)

```typescript
initialize(options: InitializeOptions) => Promise<void>
```

Initialize the plugin.

This method must be called once before all other methods.

| Param         | Type                                                            |
| ------------- | --------------------------------------------------------------- |
| **`options`** | <code><a href="#initializeoptions">InitializeOptions</a></code> |

**Since:** 0.0.1

--------------------


### uploadResource(...)

```typescript
uploadResource(options: UploadResourceOptions) => Promise<void>
```

| Param         | Type                                                                    |
| ------------- | ----------------------------------------------------------------------- |
| **`options`** | <code><a href="#uploadresourceoptions">UploadResourceOptions</a></code> |

--------------------


### Interfaces


#### InitializeOptions

| Prop            | Type                | Description                                                                         | Since |
| --------------- | ------------------- | ----------------------------------------------------------------------------------- | ----- |
| **`cloudName`** | <code>string</code> | The cloud name of your app which you can find in the Cloudinary Management Console. | 0.0.1 |


#### UploadResourceOptions

| Prop               | Type                                                  | Description                                                        | Since |
| ------------------ | ----------------------------------------------------- | ------------------------------------------------------------------ | ----- |
| **`resourceType`** | <code><a href="#resourcetype">ResourceType</a></code> | The resource type to upload.                                       | 0.0.1 |
| **`blob`**         | <code>Blob</code>                                     | The file to upload. Only available on Web.                         | 0.0.1 |
| **`uploadPreset`** | <code>string</code>                                   | The selected upload preset.                                        | 0.0.1 |
| **`path`**         | <code>string</code>                                   | The path of the file to upload. Only available on Android and iOS. | 0.0.1 |
| **`publicId`**     | <code>string</code>                                   | Assign a unique identifier to the resource.                        | 0.0.1 |


### Enums


#### ResourceType

| Members     | Value                |
| ----------- | -------------------- |
| **`image`** | <code>'image'</code> |
| **`video`** | <code>'video'</code> |
| **`raw`**   | <code>'raw'</code>   |

</docgen-api>

## Changelog

See [CHANGELOG.md](https://github.com/capawesome-team/capacitor-cloudinary/blob/main/CHANGELOG.md).

## License

See [LICENSE](https://github.com/capawesome-team/capacitor-cloudinary/blob/main/LICENSE).
