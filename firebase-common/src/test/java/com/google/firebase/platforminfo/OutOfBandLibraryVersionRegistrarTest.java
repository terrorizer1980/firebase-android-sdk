// Copyright 2018 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.firebase.platforminfo;

import static com.google.common.truth.Truth.assertThat;

import org.junit.Test;

public class OutOfBandLibraryVersionRegistrarTest {
  @Test
  public void registerVersion_persistsVersion() {
    OutOfBandLibraryVersionRegistrar outOfBandLibraryVersionRegistrar =
        new OutOfBandLibraryVersionRegistrar();
    outOfBandLibraryVersionRegistrar.registerVersion("foo", "1.1.1");

    assertThat(outOfBandLibraryVersionRegistrar.getRegisteredVersions())
        .contains(LibraryVersion.create("foo", "1.1.1"));
  }

  @Test
  public void getRegisteredVersions_returnsEmptySet_whenNoVersionsAreRegistered() {
    OutOfBandLibraryVersionRegistrar outOfBandLibraryVersionRegistrar =
        new OutOfBandLibraryVersionRegistrar();

    assertThat(outOfBandLibraryVersionRegistrar.getRegisteredVersions()).isEmpty();
  }
}
