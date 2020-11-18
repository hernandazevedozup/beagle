#
# Copyright 2020 ZUP IT SERVICOS EM TECNOLOGIA E INOVACAO SA
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#     http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
#
 
@webview @regression
Feature: WebView Component Validation

    As a Beagle developer/user
    I'd like to make sure my webview component works as expected
    In order to guarantee that my application never fails
    
    Background:
        Given the Beagle application did launch with the web view url screen
        
    Scenario Outline: WebView 01 - a web view should be displayed on the screen correctly
        Then the text "<webViewText>" from webView should appear on the screen
        
    Examples:
        | webViewText  |
        | Português    |
        | IMAGENS      |

    Scenario Outline: WebView 02 - the web view should change its url and load it correctly
        When I press a button with the "ClickToChangePage" title to change urls
        Then the text "<webViewText>" from webView should appear on the screen
    
    Examples:
        | webViewText  |
        | Overview     |
        