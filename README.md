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

Add the `CLOUDINARY_URL` meta-data property to the `android/app/src/main/AndroidManifest.xml` file, within the `application` tag:

```xml
<meta-data android:name="CLOUDINARY_URL" android:value="cloudinary://@myCloudName" />
```

**Note**: Replace `myCloudName` with your cloud name.

#### Variables

This plugin will use the following project variables (defined in your app’s `variables.gradle` file):
- `$cloudinaryAndroidVersion` version of `com.cloudinary:cloudinary-android` (default: `2.3.0`)

## Configuration

No configuration required for this plugin.

## Usage

```typescript
import { Cloudinary } from '@capawesome/capacitor-cloudinary';

const echo = async () => {
  await Cloudinary.echo();
};
```

## API

<docgen-index>

</docgen-index>

<docgen-api>
<!--Update the source file JSDoc comments and rerun docgen to update the docs below-->

</docgen-api>

## Changelog

See [CHANGELOG.md](https://github.com/capawesome-team/capacitor-cloudinary/blob/main/CHANGELOG.md).

## License

See [LICENSE](https://github.com/capawesome-team/capacitor-cloudinary/blob/main/LICENSE).
